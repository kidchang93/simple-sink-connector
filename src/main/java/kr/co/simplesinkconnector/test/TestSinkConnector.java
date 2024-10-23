package kr.co.simplesinkconnector.test;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import java.util.List;
import java.util.Map;

/**
 * 사용자 정의 클래스 선언.
 * 최종적으로 커넥트에서 호출할 때 사용되므로 명확하게 어떻게 사용되는 커넥터인지 알 수 있는 이름을 적으면 좋다.
 */
public class TestSinkConnector extends SinkConnector {

    /**
     * 사용자가 JSON 또는 config 파일 형태로 입력한 설정값을 초기화 하는 메서드.
     * 올바른 값이 아니라면 ConnectException()을 호출하여 커넥터를 종료할 수 있다.
     * ex) JDBC 소스 커넥터 - JDBC 커넥션 URL 값을 검증하는 로직을 넣을 수 있다.
     * @param map
     */
    @Override
    public void start(Map<String, String> map) {

    }

    /**
     * 이 커넥터가 사용할 태스크 클래스를 지정한다.
     * @return
     */
    @Override
    public Class<? extends Task> taskClass() {
        return null;
    }

    /**
     * 태스크 개수가 2개 이상인 경우 태스크마다 각기 다른 옵셔늘 설정할 때 사용한다.
     * @param i
     * @return
     */
    @Override
    public List<Map<String, String>> taskConfigs(int i) {
        return List.of();
    }

    @Override
    public void stop() {

    }

    /**
     * 커넥터가 사용할 설정값에 대한 정보를 받는다.
     * 커넥터의 설정값은 ConfigDef 클래스를 통해 각 설정의 이름, 기본값, 중요도, 설명을 정의할 수 있다.
     * @return
     */
    @Override
    public ConfigDef config() {
        return null;
    }

    @Override
    public String version() {
        return "";
    }
}
