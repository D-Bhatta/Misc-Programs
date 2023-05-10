# Use vault to hold configuration

## Sections

## Notes

## Start a dev server

- Use `vault server -dev -dev-no-store-token` to start a dev server.
- In another powershell window use `$env:VAULT_ADDR=""` to set the vault server address and `$env:VAULT_TOKEN=""` to set the root token.
- Copy the unseal key and store it somewhere.
- Use `vault status` to check the status.

## Store a secret

- Use `vault kv put -mount=secret hello foo=world` to store a secret. Use `vault kv get -mount=secret hello` to retrieve a secret.
- To retrieve a specific field in a specific format, use `vault kv get -mount=secret -format=yaml -field=foo hello`.
- Use a `-` to avoid storing something in the shell history like `vault kv put -mount=secret hello foo=world cat=-`. Then input the secret and use `Ctrl + Z` and return to terminate.

## Enable AppRole and create ACL policy

- Go to `http://127.0.0.1:8200/ui/` to access the Vault UI and input the root token.
- `Access` -> `Enable new method` -> `AppRole` -> `Next` -> `Enable Method`.
- `Policies` -> `Create ACL policy`
- Input the following with the name `readonly-postgresql-v1-0-0`

```HCL
path "secret/data/posgresql-v-1-0-0/webapp-v-1-0-0" {
    capabilities = [ "read" ]
}
```

## Create an approle

- Create an approle with `vault write auth/approle/role/node-app-role-v-1-0-0 token_ttl=1h token_max_ttl=4h token_policies=readonly-postgresql-v1-0-0`.

## Retrieve role and secret ID

- Retrieve RoleID with `vault read auth/approle/role/node-app-role-v-1-0-0/role-id`.
- Retrieve SecretID with `vault write -f auth/approle/role/node-app-role-v-1-0-0/secret-id`

## Store webapp secrets

- Use `vault kv put secret/posgresql-v-1-0-0/webapp-v-1-0-0 test=-` to enter values.
- Use `vault kv patch secret/posgresql-v-1-0-0/webapp-v-1-0-0 username=-` to update without overwriting.

## Script
