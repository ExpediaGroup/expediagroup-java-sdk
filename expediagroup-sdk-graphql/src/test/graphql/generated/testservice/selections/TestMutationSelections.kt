//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '4.1.1'.
//
package testservice.selections

import com.apollographql.apollo.api.CompiledField
import com.apollographql.apollo.api.CompiledSelection
import com.apollographql.apollo.api.notNull
import kotlin.collections.List
import testservice.type.GraphQLString
import testservice.type.TestData

public object TestMutationSelections {
  private val __testMutation: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLString.type.notNull()
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "testMutation",
          type = TestData.type.notNull()
        ).selections(__testMutation)
        .build()
      )
}
