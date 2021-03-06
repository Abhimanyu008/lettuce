/*
 * Copyright 2011-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lambdaworks.redis.cluster;

import static org.assertj.core.api.Assertions.assertThat;

import com.lambdaworks.redis.protocol.CommandType;
import com.lambdaworks.redis.protocol.ProtocolKeyword;
import org.junit.Test;

/**
 * @author Mark Paluch
 */
public class ReadOnlyCommandsTest {

    @Test
    public void testCount() throws Exception {
        assertThat(ReadOnlyCommands.READ_ONLY_COMMANDS).hasSize(71);
    }

    @Test
    public void testResolvableCommandNames() throws Exception {
        for (ProtocolKeyword readOnlyCommand : ReadOnlyCommands.READ_ONLY_COMMANDS) {
            assertThat(readOnlyCommand.name()).isEqualTo(CommandType.valueOf(readOnlyCommand.name()).name());
        }
    }
}
