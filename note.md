```json
{
  "allClusterInfo": {
    "brokerAddrTable": {
      "broker-a": {
        "brokerAddrs": {
          0: "10.1.20.49:10910"
        },
        "brokerName": "broker-a",
        "cluster": "TomsCluster"
      }
    },
    "clusterAddrTable": {
      "TomsCluster": [
        "broker-a"
      ]
    }
  },
  "allTopicList": {
    "topicList": [
      "SCHEDULE_TOPIC_XXXX",
      "RMQ_SYS_TRANS_HALF_TOPIC",
      "BenchmarkTest",
      "OFFSET_MOVED_EVENT",
      "TomsCluster",
      "broker-a",
      "TBW102",
      "TomsCluster_REPLY_TOPIC",
      "SELF_TEST_TOPIC"
    ]
  },
  "hasUnitSubTopicList": {"topicList":[]},
  "hasUnitSubUnUnitTopicList": {
    "topicList": []
  },
  "systemTopicList": {
    "brokerAddr": "10.1.20.49:10910",
    "topicList": [
      "TomsCluster",
      "broker-a"
    ]
  },
  "unitTopics": {
    "topicList": []
  }
}
```