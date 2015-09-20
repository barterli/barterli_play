package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.Singleton;
import models.entities.User;
import play.db.jpa.Transactional;
import play.libs.Akka;
import play.libs.F;
import play.libs.HttpExecution;
import play.libs.Json;
import play.mvc.BodyParser;
import play.mvc.Controller;
import play.mvc.Result;
import scala.concurrent.ExecutionContext;
import views.html.index;

/**
 * Created by suren on 19/9/15.
 */

@Singleton
public class Users extends Controller {

    @BodyParser.Of(BodyParser.Json.class)
    @Transactional
    public F.Promise<Result> create() {
        ExecutionContext dbWriteThreadPool = Akka.system().dispatchers().lookup("contexts.db-write-context");
        ExecutionContext dbWriteContext = HttpExecution.fromThread(dbWriteThreadPool);
        Gson gson = new GsonBuilder().create();
        JsonNode UserJson = request().body().asJson().findPath("user");
        User user  = gson.fromJson(UserJson.toString(), User.class);
        F.Promise<User> promise = F.Promise.promise(() -> User.create(user), dbWriteContext);
        return promise.map((User userObj) -> ok(gson.toJson(userObj)));
    }

    @Transactional(readOnly = true)
    public Result show() {
        return ok(index.render("Your new application is ready."));
    }

}
