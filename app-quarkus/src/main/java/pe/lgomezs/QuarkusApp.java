package pe.lgomezs;



import com.microsoft.sqlserver.jdbc.SQLServerException;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@QuarkusMain
public class QuarkusApp {

    public static void main(String... args) throws SQLServerException {
       // initializersKeyStoreProviders();
        //new KeyStoreProvidersInitializer().initialize();
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            log.info("Do startup logic here");
            //initializersKeyStoreProviders();
            Quarkus.waitForExit();
            log.info("waitForExit");
            return 0;
        }

        public void initializersKeyStoreProviders() throws SQLServerException {
          //  SQLServerColumnEncryptionAzureKeyVaultProvider akvProvider = new SQLServerColumnEncryptionAzureKeyVaultProvider("b441a58a-ec6c-484a-8fd3-267e2ea6f9ea", "XvCVxNmQE3mjt9+tOFC0fFifNUNozHzomikz9UjIgJU=");
            //   Map<String, SQLServerColumnEncryptionKeyStoreProvider> keyStoreMap = new HashMap<>();
            //   keyStoreMap.put(akvProvider.getName(), akvProvider);
            //  SQLServerConnection.registerColumnEncryptionKeyStoreProviders(keyStoreMap);
        }
    }
}
