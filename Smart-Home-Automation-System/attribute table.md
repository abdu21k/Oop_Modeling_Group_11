## Smart Home Automation System - Attribute Table

### User
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| userId         | int       | Unique identifier for the homeowner |
| name           | String    | User's full name |
| email          | String    | Contact email for system notifications |
| homeLocation   | String    | Address or location where the smart devices are installed |
| registeredDevices | List<SmartDevice> | List of connected devices owned by the user |

### SmartDevice (Abstract Base Class)
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| deviceId       | int       | Unique identifier for each smart device |
| deviceName     | String    | Name of the device (e.g., Living Room Light) |
| status        | boolean    | Whether the device is ON or OFF |
| location      | String     | Physical placement of the device in the home |
| connectionState | boolean  | Whether the device is connected to the network |

### SmartLight (Inherits SmartDevice)
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| brightness     | int       | Light intensity (0-100%) |
| colorMode      | String    | Color setting (Warm, Cool, RGB) |

### SmartThermostat (Inherits SmartDevice)
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| currentTemperature | double | Current room temperature |
| targetTemperature  | double | Desired temperature set by user |
| mode            | String    | Heating, Cooling, or Auto mode |

### SmartDoor (Inherits SmartDevice)
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| isLocked       | boolean   | Lock status of the door |
| accessLogs     | List<String> | List of recent unlock attempts |

### SmartSensor (Inherits SmartDevice)
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| sensorType     | String    | Motion, Temperature, Smoke, etc. |
| detectedValue  | double    | Current value detected by the sensor |
| alertStatus    | boolean   | Whether an alert is triggered |

### AutomationRule
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| ruleId        | int       | Unique identifier for an automation rule |
| triggerEvent  | String    | Condition that activates the rule (e.g., Motion detected) |
| action        | String    | The action performed when the trigger event occurs (e.g., Turn on lights) |
| scheduleTime  | String    | Optional scheduled time for execution |

### System Settings
| Attribute       | Data Type  | Description |
|----------------|-----------|-------------|
| wifiSSID       | String    | Name of the home Wi-Fi network |
| securityMode   | String    | Home security level (Standard, Enhanced) |
| energySaver    | boolean   | Whether the system optimizes energy consumption |
