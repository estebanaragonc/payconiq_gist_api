package api_test.gist;

public class GistFiles {

	/* based in 
	 * "files": {
     * "hello_world.rb": {
     * "filename": "hello_world.rb",
     * "type": "application/x-ruby",
     * "language": "Ruby",
     * "raw_url": "https://gist.githubusercontent.com/octocat/6cad326836d38bd3a7ae/raw/db9c55113504e46fa076e7df3a04ce592e2e86d8/hello_world.rb",
     * "size": 167
     *}
     */
	private int size;
    private String rawUrl;
    private String type;
    private boolean truncated;
    private String language;
    private String content;

    public GistFiles() {
    }

    public GistFiles(String content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
   
}
