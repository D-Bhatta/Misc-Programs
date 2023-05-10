(async () => {
  const { createConfigs } = await import("./config.js");
  await createConfigs();
  import("./app/app.js");
})();
