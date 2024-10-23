package kr.co.simplesinkconnector;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;
import org.springframework.boot.SpringApplication;

import java.util.Map;

public class SingleFileSinkConnectorConfig extends AbstractConfig {

    // 토픽의 데이터를 저장할 파일 이름을 옵션값으로 받기 위해 선언한다.
    // 토픽이 옵션값에 없는 이유는 커넥트를 통해 커넥터를 실행 시 기본값으로 받아야 하기 때문이다.
    // 그렇기 때문에 싱크 커넥터의 옵션값으로 토픽은 추가하지 않아도 된다.
    public static final String DIR_FILE_NAME = "file";
    public static final String DIR_FILE_NAME_DEFAULT_VALUE = "/tmp/kafka.txt";
    private static final String DIR_FILE_NAME_DOC = "읽을 파일 경로와 이름";


    public static ConfigDef CONFIG = new ConfigDef().define
            (
                    DIR_FILE_NAME,
                    Type.STRING,
                    DIR_FILE_NAME_DEFAULT_VALUE,
                    Importance.HIGH,
                    DIR_FILE_NAME_DOC
            );

    public static void main(String[] args) {
        SpringApplication.run(SingleFileSinkConnectorConfig.class, args);
    }




    public SingleFileSinkConnectorConfig(Map<String,String> props) {
        super(CONFIG,props);
    }

}
