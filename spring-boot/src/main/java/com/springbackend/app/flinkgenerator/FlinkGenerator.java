// package com.springbackend.app.flinkgenerator;

// import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
// import org.apache.flink.streaming.api.functions.source.SourceFunction;
// import org.apache.flink.streaming.api.functions.source.SourceContext;
// import org.apache.flink.api.common.serialization.SimpleStringSchema;
// import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
// import org.apache.flink.streaming.api.datastream.DataStream;
// import org.apache.flink.api.common.functions.MapFunction;

// import java.util.Properties;

// public class FlinkGenerator {
//     public static void main(String[] args) throws Exception {
//         // Flink akış ortamını başlat
//         StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

//         // Kafka'ya bağlantı için gerekli olan özellikler
//         Properties properties = new Properties();
//         properties.setProperty("bootstrap.servers", "localhost:9092");
//         properties.setProperty("group.id", "flink-group");

//         // Kafka konfigürasyonlarıyla birlikte bir FlinkKafkaConsumer oluştur
//         FlinkKafkaConsumer<String> kafkaConsumer = new FlinkKafkaConsumer<>("earthquake-topic", new SimpleStringSchema(), properties);

//         // Kafka'dan gelen verileri işlemek için bir veri akışı oluştur
//         DataStream<String> dataStream = env.addSource(kafkaConsumer);

//         // Veri akışını işleyerek kuyruğa ekleyebilir veya başka bir işlem yapabiliriz
//         DataStream<String> processedStream = dataStream.map(new MapFunction<String, String>() {
//             @Override
//             public String map(String value) throws Exception {
//                 // Veriyi işle
//                 return value.toUpperCase(); // Örneğin, burada veriyi büyük harfe dönüştürüyoruz
//             }
//         });

//         // İşlenmiş veriyi başka bir kuyruğa veya başka bir hedefe gönderebiliriz
//         processedStream.print();

//         // Flink işlemini başlat
//         env.execute("Flink Processor");
//     }
// }
