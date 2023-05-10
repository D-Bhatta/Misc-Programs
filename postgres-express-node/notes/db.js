import pg from "pg";
import configs from "./config.js";
const { databaseName, userName, userPassword, databaseHost, databasePort } = configs;
const { Client } = pg;
const client = new Client({
  user: userName,
  host: databaseHost,
  database: databaseName,
  password: userPassword,
  port: databasePort,
});
client.connect();

export default client;
