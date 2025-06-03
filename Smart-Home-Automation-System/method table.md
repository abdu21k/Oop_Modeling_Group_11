

User (HomeOwner) Methods
| Method Name | Return Type | Description | 
| addDevice(SmartDevice device) | void | Adds a smart device to the user's registered list. | 
| listDevices() | void | Displays the status of all connected devices. | 



SmartDevice (Base Class) Methods
| Method Name | Return Type | Description | 
| turnOn() | void | Turns the device ON. | 
| turnOff() | void | Turns the device OFF. | 
| getStatus() | String | Returns the current status of the device. | 



SmartLight Methods
| Method Name | Return Type | Description | 
| setBrightness(int level) | void | Adjusts light intensity (0-100%). | 
| setColorMode(String mode) | void | Sets the color mode (Warm, Cool, RGB). | 



SmartThermostat Methods
| Method Name | Return Type | Description | 
| setTargetTemperature(double temp) | void | Sets the desired temperature. | 
| setMode(String mode) | void | Changes the thermostat mode (Heating, Cooling, Auto). | 



SmartDoor Methods
| Method Name | Return Type | Description | 
| lockDoor() | void | Locks the door. | 
| unlockDoor() | void | Unlocks the door and records access logs. | 



SmartSensor Methods
| Method Name | Return Type | Description | 
| detectValue(double value) | void | Detects environmental changes and triggers alerts if necessary. | 



AutomationRule Methods
| Method Name | Return Type | Description | 
| AutomationRule(int ruleId, String triggerEvent, String action, String scheduleTime) | Constructor | Defines an automation rule with trigger conditions and actions. | 



System Settings Methods
| Method Name | Return Type | Description | 
| SmartHomeSettings(String wifiSSID, String securityMode, boolean energySaver) | Constructor | Initializes system settings. | 

