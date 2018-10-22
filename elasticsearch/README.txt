1.下载
wget  https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-5.6.8.tar.gz
2.解压
tar -zxvf elasticsearch-5.6.8.tar.gz
3.外网访问配置：
config目录下面elasticsearch.yml，修改为 network.host: 0.0.0.0
4.访问
http://localhost:8080/api/article/save?id=1&title=packy
http://localhost:8080/api/article/search?title=packy
5.elastic命令
查看集群状态：192.168.179.2:9200/_cat/health?v
查看节点状态：192.168.179.2:9200/_cat/nodes?v
查看索引列表：192.168.179.2:9200/_cat/indices?v
查看blog索引下article type下id为1的数据：192.168.179.2:9200/blog/article/1
6.与MySQL对比
mysql：database   table                       record
es   : index      type（6.0开始只能存在一个)   document