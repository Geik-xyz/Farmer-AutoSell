# Farmer AutoSell Module

A simple Farmer plugin module that automatically sells stocked items for the farm owner and deposits the proceeds.

---

## 📦 Installation

1. Place the `AutoSell` folder into `plugins/Farmer/modules/`.  
2. Restart your server.  
3. A `config.yml` and matching language file will be generated under `plugins/Farmer/modules/AutoSell/`.

---

## ⚙️ Features

- **Automatic Stock Selling**  
  When a farmer’s inventory reaches capacity, all stocked items are sold for the configured price.

- **Farm Owner Payout**  
  Proceeds go directly to the farmer’s account via your economy plugin.

- **Enable/Disable Toggle**  
  Turn the AutoSell behavior on or off via the `enabled` setting.

- **Item Inclusion List**  
  Specify exactly which materials should be auto-sold when stocked.

---

## 🔧 Configuration

All options and inline comments are available in `config.yml` (inside the AutoSell module folder). Key settings include:

- **enabled**  
  Set to `true` or `false` to enable or disable automatic selling.

- **prices**  
  Map material names to sale prices per item.

- **include-items**  
  List the materials that should be processed by AutoSell.

---

## 🤝 Contributing

1. Fork the repository.  
2. Implement your improvements or bug fixes.  
3. Open a pull request against the `develop` branch.  

Please adhere to existing code style and update documentation as needed.

---
