package entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Message {
    private long fromId;
    private long toId;
    private String type;
    private String message;


    public Message(long fromId, long toId, String message) {
        this.fromId = fromId;
        this.toId = toId;
        this.message = message;
    }

    public Message(String type, String message) {
        this.type = type;
        this.message = message;
    }


}
