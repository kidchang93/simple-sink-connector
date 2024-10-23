package kr.co.simplesinkconnector.test;

import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.connect.sink.SinkRecord;
import org.apache.kafka.connect.sink.SinkTask;

import java.util.Collection;
import java.util.Map;

public class TestSinkTask extends SinkTask {

    @Override
    public String version() {
        return "";
    }

    /**
     * 태스크가 시작할 때 필요한 로직을 작성.
     * 태스크는 실질적으로 데이터를 처리하는 역할을 하므로
     * 데이터 처리에 필요한 모든 리소스를 여기서 초기화 하면 좋다.
     * 예를들어 JDBC 소스커넥터를 구현한다면 이 메서드에서 JDBC 커넥션을 맺는다.
     * @param map
     */
    @Override
    public void start(Map<String, String> map) {

    }


    /**
     * 싱크 애플리케이션 또는 싱크 파일에 저장할 데이터를 토픽에서 주기적으로 가져오는 메서드
     * 토픽의 데이터들은 여러개의 SinkRecord를 묶어 파라미터로 사용할 수 있다.
     * SinkRecord는 토픽의 한 개 레코드이며 토픽,파티션,타임스탬프 등의 정보를 담고 있다.
     * @param collection
     */
    @Override
    public void put(Collection<SinkRecord> collection) {

    }

    /**
     * put()메서드를 통해 가져온 데이터를 일정주기로 싱크 애플리케이션 또는 싱크 파일에 저장할 때 사용되는 로직
     * 예를 들어 JDBC 커넥션을 맺어서 MySQL에 데이터를 저장할 때 put() 메서드에서는 데이터를 insert 하고
     * flush() 메서드에서는 commit 을 수행하여 트랜잭션을 끝낼 수 있다.
     * put() 메서드에서 레코드를 저장하는 로직을 넣을 수도 있으며 이 경우에는
     * flush() 메서드에는 로직을 구현하지 않아도 된다.
     * @param currentOffsets
     */
    @Override
    public void flush(Map<TopicPartition, OffsetAndMetadata> currentOffsets) {

    }

    @Override
    public void stop() {

    }
}
