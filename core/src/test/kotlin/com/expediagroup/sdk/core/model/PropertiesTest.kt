/*
 * Copyright (C) 2022 Expedia, Inc.
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
package com.expediagroup.sdk.core.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.FileNotFoundException
import java.net.URL

class PropertiesTest {
    companion object {
        private const val DUMMY_DATA_FILE_PATH = "dummy-data.properties"
    }

    @Test
    fun `should load properties from file`() {
        val properties = Properties.from(javaClass.classLoader.getResource(DUMMY_DATA_FILE_PATH)!!)
        assert(properties["key1"] == "value1")
        assert(properties["key2"] == "value2")
    }

    @Test
    fun `should return null if key is not found`() {
        val properties = Properties.from(javaClass.classLoader.getResource(DUMMY_DATA_FILE_PATH)!!)
        assert(properties["key3"] == null)
    }

    @Test
    fun `should throw exception if file is not found`() {
        assertThrows<FileNotFoundException> {
            Properties.from(URL("file:///non-existent-file.properties"))
        }
    }
}
