import { vaultItems } from "./vault.js";
const configs = {};

export async function createConfigs() {
  const vaultData = await vaultItems();

  for (const vaultItem in vaultData) {
    configs[vaultItem] = vaultData[vaultItem];
  }
  return configs;
}

export default configs;
