package pe.lgomezs.config;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KeyStoreProvidersInitializer {

    public void initialize() {
        log.info("  ################ initialize encrypt columns sql () ################################");

       // Assert.notNull(ConfigProvider.getConfig().getValue("keyvault.id", String.class), "azure.keyvault.client-id must not be null!");
       // Assert.notNull(ConfigProvider.getConfig().getValue("keyvault.key", String.class), "azure.keyvault.client-key must not be null!");

        //String id = ConfigProvider.getConfig().getValue("keyvault.id", String.class);
        //String key = ConfigProvider.getConfig().getValue("keyvault.key", String.class);

        //log.info("id {} ", id);
        //log.info("key {} ", key);

        // try {
          //  log.info("initializing DataSource AlwaysEncryption Vault provider");
            //  val keyStoreMap = getClientKeyStoreProviders("b441a58a-ec6c-484a-8fd3-267e2ea6f9ea", "XvCVxNmQE3mjt9+tOFC0fFifNUNozHzomikz9UjIgJU=");
            //  SQLServerConnection.registerColumnEncryptionKeyStoreProviders(keyStoreMap);

        //  } catch (SQLServerException e) {
        //   log.error("Error en inicializar la db", e);
        //   throw new RuntimeException(e);
        // }
    }

    // Map<String, SQLServerColumnEncryptionKeyStoreProvider> getClientKeyStoreProviders(String clientID, String clientKey) throws SQLServerException {
    //    val akvProvider = new SQLServerColumnEncryptionAzureKeyVaultProvider(clientID, clientKey);
    //  val keyStoreMap = new HashMap<String, SQLServerColumnEncryptionKeyStoreProvider>();

    //  keyStoreMap.put(akvProvider.getName(), akvProvider);

    //   return keyStoreMap;
    // }
}
