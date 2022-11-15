import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import pack.Album;
import pack.Comment;
import pack.Photo;
import pack.Post;
import pack.user.User;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Gson_parser {
    public static void start() throws IOException {
        while (true) {
            String path = MyUtils.getStringPath(".json".toLowerCase());
            StringBuilder sb = new StringBuilder();
            if (path.equals("exit")) {
                return;
            }
            if (path.endsWith("users.json".toLowerCase())) {
                Gson_parser gson_parser = new Gson_parser();
                Type type = new TypeToken<List<User>>() {
                }.getType();
                List<User> users = gson_parser.parse(path, type);
                sb.append("INSERT INTO users(id, name, username, email, address, phone, website, company) VALUES");
                for (User user : users) {
                    sb.append("(")
                            .append(user.getId()).append(", ")
                            .append("'").append(user.getName()).append("'").append(", ")
                            .append("'").append(user.getUsername()).append("'").append(", ")
                            .append("'").append(user.getEmail()).append("'").append(", ")
                            .append("'").append(user.getAddress().toString()).append("'").append(", ")
                            .append("'").append(user.getPhone()).append("'").append(", ")
                            .append("'").append(user.getWebsite()).append("'").append(", ")
                            .append("'").append(user.getCompany().toString()).append("'")
                            .append(")").append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                MyConnection.connect(sb.toString());
                break;
            } else if (path.endsWith("posts.json".toLowerCase())) {
                Gson_parser gson_parser = new Gson_parser();
                Type type = new TypeToken<List<Post>>() {
                }.getType();
                List<Post> posts = gson_parser.parse(path, type);
                sb.append("INSERT INTO posts(userId, id, title, body) VALUES");
                for (Post post : posts) {
                    sb.append("(")
                            .append(post.getUserId()).append(", ")
                            .append(post.getId()).append(", ")
                            .append("'").append(post.getTitle()).append("'").append(", ")
                            .append("'").append(post.getBody()).append("'")
                            .append(")").append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                MyConnection.connect(sb.toString());
                break;
            } else if (path.endsWith("photos.json".toLowerCase())) {
                Gson_parser gson_parser = new Gson_parser();
                Type type = new TypeToken<List<Photo>>() {
                }.getType();
                List<Photo> photos = gson_parser.parse(path, type);
                sb.append("INSERT INTO photos(albumId, id, title, url, photos) VALUES");
                for (Photo photo : photos) {
                    sb.append("(")
                            .append(photo.getAlbumId()).append(", ")
                            .append(photo.getId()).append(", ")
                            .append("'").append(photo.getTitle()).append("'").append(", ")
                            .append("'").append(photo.getUrl()).append("'").append(", ")
                            .append("'").append(photo.getPhotos()).append("'")
                            .append(")").append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                MyConnection.connect(sb.toString());
                break;
            } else if (path.endsWith("albums.json".toLowerCase())) {
                Gson_parser gson_parser = new Gson_parser();
                Type type = new TypeToken<List<Album>>() {
                }.getType();
                List<Album> albums = gson_parser.parse(path, type);
                sb.append("INSERT INTO albums(userId, id, title) VALUES");
                for (Album album : albums) {
                    sb.append("(")
                            .append(album.getUserId()).append(", ")
                            .append(album.getId()).append(", ")
                            .append("'").append(album.getTitle()).append("'")
                            .append(")").append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                MyConnection.connect(sb.toString());
                break;
            } else if (path.endsWith("comments.json".toLowerCase())) {
                Gson_parser gson_parser = new Gson_parser();
                Type type = new TypeToken<List<Comment>>() {
                }.getType();
                List<Comment> comments = gson_parser.parse(path, type);
                sb.append("INSERT INTO comments(postId, id, name, email, body) VALUES");
                for (Comment comment : comments) {
                    sb.append("(")
                            .append(comment.getPostId()).append(", ")
                            .append(comment.getId()).append(", ")
                            .append("'").append(comment.getName()).append("'").append(", ")
                            .append("'").append(comment.getEmail()).append("'").append(", ")
                            .append("'").append(comment.getBody()).append("'")
                            .append(")").append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                MyConnection.connect(sb.toString());
                break;
            } else {
                System.out.println("Incorrect choose!");
            }
            System.out.println("is entered into the database");
        }
    }

    private <E> List<E> parse(String path, Type type) throws IOException {
        Gson gson = new Gson();
        Path path1 = Paths.get(path);
        String item = new String(Files.readAllBytes(path1));
        List<E> list = gson.fromJson(item, type);
        return gson.fromJson(item, type);
    }
}
