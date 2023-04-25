package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */
class AsyncTest {

    private static List<Enterprise> enterprises = List.of(
            new Enterprise("ent_1", "Google", "ceo_2"),
            new Enterprise("ent_2", "Facebook", "ceo_1")
    );

    private static List<Ceo> ceos = List.of(
            new Ceo("ceo_1", "Mark"),
            new Ceo("ceo_2", "Sundar"),
            new Ceo("ceo_3", "Bill")
    );

    public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> ceos.find(x -> ceo_id.equals(x.id)));
    }

    public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> enterprises.find(x -> ceo_id.equals(x.ceo_id)));
    }

    public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return new Tuple2<>(getCeoById(ceo_id).get(), getEnterpriseByCeoId(ceo_id).get());
            } catch (InterruptedException | ExecutionException e) {
                return new Tuple2<>(Option.none(), Option.none());
            }
        });
    }
}
