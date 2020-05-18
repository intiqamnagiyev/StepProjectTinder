package model;

public class Message {
private String type;
private String message;
private String writeTo;

    public Message() {
    }

    public Message(String type, String message, String writeTo) {
        this.type = type;
        this.message = message;
        this.writeTo = writeTo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWriteTo() {
        return writeTo;
    }

    public void setWriteTo(String writeTo) {
        this.writeTo = writeTo;
    }

    @Override
    public String toString() {
        return String.format("Message{type='%s', message='%s', writeTo='%s'}", type, message, writeTo);
    }
}


