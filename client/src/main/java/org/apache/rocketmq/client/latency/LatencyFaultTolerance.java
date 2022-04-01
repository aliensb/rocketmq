/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.client.latency;

public interface LatencyFaultTolerance<T> {
    /**
     * 更新失败的条目数
     * @param name 失败条目的名称（这里是brokerName）
     * @param currentLatency 消息发送故障延迟时间
     * @param notAvailableDuration 不可用的持续时间，也就是说着这个时间内，broker将被排除在备选中
     */
    void updateFaultItem(final T name, final long currentLatency, final long notAvailableDuration);

    /**
     * 判断这个name这个条目是否可用
     * @param name 这里是brokerName
     * @return
     */
    boolean isAvailable(final T name);

    /**
     * 条目可用后将其中不可用的列表中删除
     * @param name
     */
    void remove(final T name);


    /**
     * 尝试从规避的broker中选一个可用的出来，如果没有，返回null
     * @return
     */
    T pickOneAtLeast();
}
