package com.amazonaws.kafka.samples;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.amazonaws.services.lambda.runtime.events.KafkaEvent;
import com.amazonaws.services.schemaregistry.deserializers.avro.AWSKafkaAvroDeserializer;
import com.amazonaws.services.schemaregistry.utils.AWSSchemaRegistryConstants;
import com.amazonaws.services.schemaregistry.utils.AvroRecordType;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificData;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;

import samples.clickstream.avro.ClickEvent;

class ProcessRecords {


    static final private String[] deviceType = {"mobile","computer", "tablet"};
    static final private String[] productCatalogOptions = {"home_page", "product_detail"};
    static final private String[] productTypeOptions = {"cell phones", "laptops", "ear phones", "soundbars", "cd players", "AirPods", "video games", "cameras"};
    static final private String[] productDetailOptions = {"product_catalog", "add_to_cart"};
    static final private String[] addToCartOptions = {"product_catalog", "remove_from_cart", "order"};
    static final private String[] orderOptions = {"order_checkout", "remove_from_cart", "product_catalog"};
    static final private String[] removeFromCartOptions = {"", "product_detail", "product_catalog"};
    private Long previousGlobalSeqNo = 0L;
    static AtomicLong counter = new AtomicLong(0);
    private Random rand = new Random();
    private static AtomicInteger userIDMax = new AtomicInteger(1000);

    private static final Logger logger = LogManager.getLogger(ProcessRecords.class);

    private byte[] base64Decode(KafkaEvent.KafkaEventRecord kafkaEventRecord) {
        return Base64.getDecoder().decode(kafkaEventRecord.getValue().getBytes());
    }

    private long getKafkaEventRecordsSize(KafkaEvent kafkaEvent) {
        long size = 0L;
        for (Map.Entry<String, List<KafkaEvent.KafkaEventRecord>> kafkaEventEntry : kafkaEvent.getRecords().entrySet()) {
            size += kafkaEventEntry.getValue().size();
        }
        return size;
    }

    private Map<String, Object> getGSRConfigs() {
        Map<String, Object> gsrConfigs = new HashMap<>();
        gsrConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        gsrConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, AWSKafkaAvroDeserializer.class.getName());
        gsrConfigs.put(AWSSchemaRegistryConstants.AWS_REGION, System.getenv("AWS_REGION"));
        //gsrConfigs.put(AWSSchemaRegistryConstants.AWS_REGION, "us-east-1");
        gsrConfigs.put(AWSSchemaRegistryConstants.AVRO_RECORD_TYPE, AvroRecordType.SPECIFIC_RECORD.getName());
        logger.error("=====> getGSRConfigs 1 ");
        if (System.getenv("SECONDARY_DESERIALIZER") != null) {
            logger.error("=====> getGSRConfigs 2 ");
            if (Boolean.parseBoolean(System.getenv("SECONDARY_DESERIALIZER"))) {
                gsrConfigs.put(AWSSchemaRegistryConstants.SECONDARY_DESERIALIZER, KafkaAvroDeserializer.class.getName());
                gsrConfigs.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, System.getenv("SCHEMA_REGISTRY_URL"));
                gsrConfigs.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
            }
            logger.error("=====> getGSRConfigs 3 ");
        }
        return gsrConfigs;
    }

    private Map<String, Object> getCSRConfigs() {
        Map<String, Object> csrConfigs = new HashMap<>();
        csrConfigs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        csrConfigs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        csrConfigs.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
        return csrConfigs;
    }

    private void deserializeAddToFirehoseBatch(Deserializer deserializer, KafkaEvent kafkaEvent, String requestId, SendKinesisDataFirehose sendKinesisDataFirehose) {
        kafkaEvent.getRecords().forEach((key, value) -> value.forEach(v -> {

            samples.clickstream.avro.ClickEvent clickEvent = null;
            //Event event = null;
            boolean csr = false;

            logger.error("=====> AQUI ENTRA 1 " + v.getTopic() + " " + v.getValue());

            if (System.getenv("CSR") != null) {
                logger.error("=====> AQUI ENTRA 2 " + System.getenv("CSR"));

                if (Boolean.parseBoolean(System.getenv("CSR"))) {
                    logger.error("=====> AQUI ENTRA 3 " + System.getenv("CSR"));
                    csr = true;
                    try {
                        GenericRecord rec = (GenericRecord) deserializer.deserialize(v.getTopic(), base64Decode(v));
                        clickEvent = (samples.clickstream.avro.ClickEvent) SpecificData.get().deepCopy(samples.clickstream.avro.ClickEvent.SCHEMA$, rec);
                        //event = (Event) SpecificData.get().deepCopy(Event.SCHEMA$, rec);
                    } catch (Exception e) {
                        logger.error(com.amazonaws.kafka.samples.Util.stackTrace(e));
                    }
                }
                logger.error("=====> AQUI ENTRA 4 " + System.getenv("CSR"));
            }

            logger.error("=====> AQUI ENTRA 5 " + System.getenv("CSR"));
            if (!csr) {
                try{
                    logger.error("=====> Clase NULA " + clickEvent);
                    logger.error("=====> AQUI ENTRA 6 " + v.getTopic() + " " + v.getValue());
                    logger.error("=====> AQUI ENTRA 7 " + v.getTopic() + " " + v.getValue());
                    logger.error("=====> Clase NULA " + clickEvent);
                    logger.error("=====> Clase NULA " + new ClickEvent());
                    //clickEvent = (samples.clickstream.avro.ClickEvent) deserializer.deserialize(v.getTopic(), base64Decode(v));
                    String userDeviceType = deviceType[rand.nextInt(deviceType.length)];
                    String userIP = "66.249.1." + rand.nextInt(255);
                    String eventType = productCatalogOptions[rand.nextInt(productCatalogOptions.length)];
                    String productType = productTypeOptions[rand.nextInt(productTypeOptions.length)];
                    Integer userCount = 0;
                    Integer currUserIDLimit;
                    Integer userIDLimit;
                    Integer userID = rand.nextInt(1000) ;
                    
                    
                    clickEvent = ClickEvent.newBuilder()
                    .setIp(userIP)
                    .setProductType(productType)
                    .setUserid(userID)
                    .setEventtimestamp(System.currentTimeMillis())
                    .setDevicetype(userDeviceType)
                    .setEventType(eventType)
                    .setGlobalseq(counter.incrementAndGet())
                    .setPrevglobalseq(previousGlobalSeqNo)
                    .build();
                } catch (Exception e) {
                    logger.error(com.amazonaws.kafka.samples.Util.stackTrace(e));
                }
                //event = (Event) deserializer.deserialize(v.getTopic(), base64Decode(v));
                //samples.clickstream.avro.ClickEvent 
            }

            if (clickEvent != null)
                sendKinesisDataFirehose.addFirehoseRecordToBatch(clickEvent.toString(), requestId);
            //if (event != null)
                //sendKinesisDataFirehose.addFirehoseRecordToBatch(event.toString(), requestId);
        }));
        logger.error("=====> AQUI SALE" + kafkaEvent.getRecords());
    }

    void processRecords(KafkaEvent kafkaEvent, String requestId) {
        logger.info("Processing batch with {} records for Request ID {} \n", getKafkaEventRecordsSize(kafkaEvent), requestId);
        com.amazonaws.kafka.samples.SendKinesisDataFirehose sendKinesisDataFirehose = new SendKinesisDataFirehose();
        Deserializer deserializer = null;
        if (System.getenv("CSR") != null) {
            if (Boolean.parseBoolean(System.getenv("CSR"))) {
                SchemaRegistryClient schemaRegistryClient = new CachedSchemaRegistryClient(System.getenv("SCHEMA_REGISTRY_URL"), 10, getCSRConfigs());
                deserializer = new KafkaAvroDeserializer(schemaRegistryClient);
            }
        }

        logger.error("=====> deserializer 1 ");
        if (deserializer == null || System.getenv("CSR").equals("false")) {
            logger.error("=====> deserializer 2 ");
            deserializer = new AWSKafkaAvroDeserializer(getGSRConfigs());
        }

        deserializeAddToFirehoseBatch(deserializer, kafkaEvent, requestId, sendKinesisDataFirehose);
        com.amazonaws.kafka.samples.SendKinesisDataFirehose.sendFirehoseBatch(sendKinesisDataFirehose.getFirehoseBatch(), 0, requestId, com.amazonaws.kafka.samples.SendKinesisDataFirehose.batchNumber.incrementAndGet());
        com.amazonaws.kafka.samples.SendKinesisDataFirehose.batchNumber.set(0);
    }
}
