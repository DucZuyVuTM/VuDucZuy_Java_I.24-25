public class TextEditor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new Memento(content);
    }

    public void restore(Memento memento) {
        if (memento != null) {            
            this.content = memento.getState();
        } else {
            this.content = "";
        }
    }
}
