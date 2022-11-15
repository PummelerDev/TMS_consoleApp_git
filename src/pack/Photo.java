package pack;

public class Photo {
    private String albumId;
    private String id;
    private String title;
    private String url;
    private String photos;

    public Photo(){}

    public Photo(String albumId, String id, String title, String url, String photos) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
        this.photos = photos;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumId=" + albumId  +
                ", id=" + id  +
                ", title=" + title  +
                ", url=" + url  +
                ", photos=" + photos  +
                "}";
    }
}
