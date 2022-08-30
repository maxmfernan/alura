package br.com.alura.model;

public class ToDo {
    private String _id;
    private boolean completed;
    private String title;
    private String userId;
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "ToDo [_id=" + _id + ", completed=" + completed + ", title=" + title + ", userId=" + userId + "]";
    }

    
}
