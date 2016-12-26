package abc;

/**
 * Created by Administrator on 2016/12/24.
 */
import java.io.IOException;

public interface TokenStream{
    public Token getToken() throws IOException;
    public void consumeToken();
}

