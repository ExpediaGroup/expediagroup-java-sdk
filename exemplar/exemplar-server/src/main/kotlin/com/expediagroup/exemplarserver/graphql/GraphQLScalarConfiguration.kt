/*
 * Copyright (C) 2025 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.expediagroup.exemplarserver.graphql

import graphql.GraphQLContext
import graphql.execution.CoercedVariables
import graphql.language.StringValue
import graphql.language.Value
import graphql.schema.Coercing
import graphql.schema.CoercingParseLiteralException
import graphql.schema.CoercingParseValueException
import graphql.schema.CoercingSerializeException
import graphql.schema.GraphQLScalarType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.graphql.execution.RuntimeWiringConfigurer
import java.math.BigDecimal
import java.time.LocalDate
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

@Configuration
class GraphQLScalarConfiguration {

    @Bean
    fun runtimeWiringConfigurer(): RuntimeWiringConfigurer {
        return RuntimeWiringConfigurer { wiringBuilder ->
            wiringBuilder
                .scalar(dateScalar())
                .scalar(dateTimeScalar())
                .scalar(bigDecimalScalar())
        }
    }

    private fun dateScalar(): GraphQLScalarType {
        return GraphQLScalarType.newScalar()
            .name("Date")
            .description("LocalDate scalar")
            .coercing(object : Coercing<LocalDate, String> {
                override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String {
                    return when (dataFetcherResult) {
                        is LocalDate -> dataFetcherResult.format(DateTimeFormatter.ISO_LOCAL_DATE)
                        else -> throw CoercingSerializeException("Expected LocalDate but was ${dataFetcherResult::class.java}")
                    }
                }

                override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): LocalDate {
                    return when (input) {
                        is String -> try {
                            LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseValueException("Invalid date format: $input", e)
                        }
                        else -> throw CoercingParseValueException("Expected String but was ${input::class.java}")
                    }
                }

                override fun parseLiteral(input: Value<*>, variables: CoercedVariables, graphQLContext: GraphQLContext, locale: Locale): LocalDate {
                    return when (input) {
                        is StringValue -> try {
                            LocalDate.parse(input.value, DateTimeFormatter.ISO_LOCAL_DATE)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseLiteralException("Invalid date format: ${input.value}", e)
                        }
                        else -> throw CoercingParseLiteralException("Expected StringValue but was ${input::class.java}")
                    }
                }
            })
            .build()
    }

    private fun dateTimeScalar(): GraphQLScalarType {
        return GraphQLScalarType.newScalar()
            .name("DateTime")
            .description("OffsetDateTime scalar")
            .coercing(object : Coercing<OffsetDateTime, String> {
                override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): String {
                    return when (dataFetcherResult) {
                        is OffsetDateTime -> dataFetcherResult.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        else -> throw CoercingSerializeException("Expected OffsetDateTime but was ${dataFetcherResult::class.java}")
                    }
                }

                override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): OffsetDateTime {
                    return when (input) {
                        is String -> try {
                            OffsetDateTime.parse(input, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseValueException("Invalid datetime format: $input", e)
                        }
                        else -> throw CoercingParseValueException("Expected String but was ${input::class.java}")
                    }
                }

                override fun parseLiteral(input: Value<*>, variables: CoercedVariables, graphQLContext: GraphQLContext, locale: Locale): OffsetDateTime {
                    return when (input) {
                        is StringValue -> try {
                            OffsetDateTime.parse(input.value, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                        } catch (e: DateTimeParseException) {
                            throw CoercingParseLiteralException("Invalid datetime format: ${input.value}", e)
                        }
                        else -> throw CoercingParseLiteralException("Expected StringValue but was ${input::class.java}")
                    }
                }
            })
            .build()
    }

    private fun bigDecimalScalar(): GraphQLScalarType {
        return GraphQLScalarType.newScalar()
            .name("BigDecimal")
            .description("BigDecimal scalar")
            .coercing(object : Coercing<BigDecimal, BigDecimal> {
                override fun serialize(dataFetcherResult: Any, graphQLContext: GraphQLContext, locale: Locale): BigDecimal {
                    return when (dataFetcherResult) {
                        is BigDecimal -> dataFetcherResult
                        is Number -> BigDecimal.valueOf(dataFetcherResult.toDouble())
                        else -> throw CoercingSerializeException("Expected Number but was ${dataFetcherResult::class.java}")
                    }
                }

                override fun parseValue(input: Any, graphQLContext: GraphQLContext, locale: Locale): BigDecimal {
                    return when (input) {
                        is BigDecimal -> input
                        is Number -> BigDecimal.valueOf(input.toDouble())
                        is String -> try {
                            BigDecimal(input)
                        } catch (e: NumberFormatException) {
                            throw CoercingParseValueException("Invalid number format: $input", e)
                        }
                        else -> throw CoercingParseValueException("Expected Number or String but was ${input::class.java}")
                    }
                }

                override fun parseLiteral(input: Value<*>, variables: CoercedVariables, graphQLContext: GraphQLContext, locale: Locale): BigDecimal {
                    return when (input) {
                        is StringValue -> try {
                            BigDecimal(input.value)
                        } catch (e: NumberFormatException) {
                            throw CoercingParseLiteralException("Invalid number format: ${input.value}", e)
                        }
                        else -> throw CoercingParseLiteralException("Expected StringValue but was ${input::class.java}")
                    }
                }
            })
            .build()
    }
}
