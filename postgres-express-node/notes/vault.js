import NodeVault from "node-vault";

const vault = NodeVault({
  apiVersion: "v1",
  endpoint: "http://127.0.0.1:8200",
});

export async function vaultItems() {
  const roleID = process.env.ROLE_ID;
  const secretID = process.env.SECRET_ID;

  try {
    const result = await vault.approleLogin({
      role_id: roleID,
      secret_id: secretID,
    });

    vault.token = result.auth.client_token;

    const { data } = await vault.read(
      "secret/data/posgresql-v-1-0-0/webapp-v-1-0-0"
    );

    const databaseName = data.data.db_name;
    const userName = data.data.username;
    const userPassword = data.data.password;
    const databaseHost = data.data.host;
    const databasePort = data.data.port;

    console.log("PAM: Retrieved secret values");

    return { databaseName, userName, userPassword, databaseHost, databasePort };
  } catch (error) {
    console.error("PAM: Error retrieving secret values.");
    console.error(error);
  }
}
