package com.expediagroup.sdk.rest.trait.operation

import com.fasterxml.jackson.core.type.TypeReference

/**
 * Marker interface for operations that have a response.
 */
interface OperationResponseTrait : OperationTrait

/**
 * Marker interface for operations that do not have a response body.
 */
interface OperationNoResponseBodyTrait : OperationResponseTrait

/**
 * Marker interface for operations that have a response body.
 *
 * Note: This interface is not intended to be implemented directly. Instead, use one of the sub-interfaces.
 *
 * @param BodyType the type of the response body
 */
interface OperationResponseBodyTrait<BodyType : Any> : OperationResponseTrait

/**
 * Interface for operations that have a response body and use Jackson for serialization.
 *
 * Note: Use this interface only when the response body type deserializable by Jackson.
 *
 * @param BodyType the type of the response body
 */
interface JacksonModelOperationResponseBodyTrait<BodyType : Any> : OperationResponseBodyTrait<BodyType> {
    /**
     * Get the type identifier for the response body.
     *
     * @return the type identifier for the response body
     */
    fun getTypeIdentifier(): TypeReference<BodyType>
}
