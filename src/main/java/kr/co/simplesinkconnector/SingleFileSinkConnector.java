package kr.co.simplesinkconnector;

import org.apache.kafka.common.config.Config;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.errors.ConnectException;
import org.apache.kafka.connect.sink.SinkConnector;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleFileSinkConnector extends SinkConnector {
    public static void main(String[] args) {
        SpringApplication.run(SingleFileSinkConnector.class, args);
    }
    private Map<String, String> configProperties;

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public void start(Map<String, String> props) {
        this.configProperties = props;
        try {
          new SingleFileSinkConnectorConfig(props);
        } catch (ConfigException e){
            throw new ConnectException(e.getMessage(), e);
        }
    }

    @Override
    public Class<? extends Task> taskClass() {
        return SingleFileSinkTask.class;
    }

    /**
     * 태스크가 2개 이상인 경우 태스크마다 다른 설정값을 줄 때 사용한다.
     * 여기서는 ArrayList로 모두 동일한 설정을 담아 2개 이상이더라도 동일한 설정값을 받도록 설정.
     * @param maxTasks
     * @return
     */
    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        List<Map<String,String>> taskConfigs = new ArrayList<>();
        Map<String, String> taskProps = new HashMap<>();

        taskProps.putAll(configProperties);
        for (int i = 0; i < maxTasks; i++){
            taskConfigs.add(taskProps);
        }
        return taskConfigs;
    }

    @Override
    public void stop() {

    }

    @Override
    public ConfigDef config() {
        return SingleFileSinkConnectorConfig.CONFIG;
    }


}
