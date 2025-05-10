<h1>🏠 Smart Home Automation System – OOP Design</h1>

<h2>📌 Main Classes</h2>
<ul>
  <li>SmartDevice (abstract)</li>
  <li>SmartLight (extends SmartDevice)</li>
  <li>SmartThermostat (extends SmartDevice)</li>
  <li>SmartDoor (extends SmartDevice)</li>
  <li>SmartSensor (extends SmartDevice)</li>
  <li>User</li>
  <li>AutomationRule</li>
</ul>

<h2>🔹 Class: SmartDevice (Abstract)</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>deviceID</td><td>String</td><td>Unique identifier</td></tr>
  <tr><td>deviceName</td><td>String</td><td>Name of the device</td></tr>
  <tr><td>status</td><td>String</td><td>on / off</td></tr>
  <tr><td>location</td><td>String</td><td>Room or area in house</td></tr>
  <tr><td>connected</td><td>boolean</td><td>True if connected to system</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>turnOn()</td><td>void</td><td>Switches device on</td></tr>
  <tr><td>turnOff()</td><td>void</td><td>Switches device off</td></tr>
  <tr><td>getStatus()</td><td>String</td><td>Returns current status</td></tr>
</table>

<h2>🔹 Class: SmartLight</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>brightness</td><td>int</td><td>0–100 brightness level</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>setBrightness(level)</td><td>void</td><td>Adjust brightness</td></tr>
</table>

<h2>🔹 Class: SmartThermostat</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>temperature</td><td>float</td><td>Current temp setting</td></tr>
  <tr><td>mode</td><td>String</td><td>Heating / Cooling</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>setTemperature(temp)</td><td>void</td><td>Sets desired temperature</td></tr>
  <tr><td>setMode(mode)</td><td>void</td><td>Sets mode (heat/cool)</td></tr>
</table>

<h2>🔹 Class: SmartDoor</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>locked</td><td>boolean</td><td>True if door is locked</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>lock()</td><td>void</td><td>Locks the door</td></tr>
  <tr><td>unlock()</td><td>void</td><td>Unlocks the door</td></tr>
</table>

<h2>🔹 Class: SmartSensor</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>sensorType</td><td>String</td><td>Motion / Temperature / Light</td></tr>
  <tr><td>detected</td><td>boolean</td><td>True if motion/environment triggered</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>detect()</td><td>boolean</td><td>Returns sensor status</td></tr>
</table>

<h2>🔹 Class: User</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>userID</td><td>String</td><td>Unique user ID</td></tr>
  <tr><td>name</td><td>String</td><td>Homeowner's name</td></tr>
  <tr><td>email</td><td>String</td><td>Login email</td></tr>
  <tr><td>password</td><td>String</td><td>Password for login</td></tr>
  <tr><td>devices</td><td>List&lt;SmartDevice&gt;</td><td>All linked devices</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>addDevice(device)</td><td>void</td><td>Adds a new smart device</td></tr>
  <tr><td>removeDevice(deviceID)</td><td>void</td><td>Removes device by ID</td></tr>
  <tr><td>controlDevice(deviceID, command)</td><td>void</td><td>Sends command to device</td></tr>
</table>

<h2>🔹 Class: AutomationRule</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>ruleID</td><td>String</td><td>Unique rule ID</td></tr>
  <tr><td>trigger</td><td>String</td><td>Condition (e.g. "11PM", "motionDetected")</td></tr>
  <tr><td>action</td><td>String</td><td>Action (e.g. "turnOffAllLights")</td></tr>
</table>

<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>evaluate()</td><td>boolean</td><td>Checks if trigger condition is met</td></tr>
  <tr><td>execute()</td><td>void</td><td>Executes associated action</td></tr>
</table>

<h2>🔄 Relationships</h2>
<ul>
  <li>User ⟶ many SmartDevices</li>
  <li>SmartDevice is abstract and inherited by SmartLight, SmartThermostat, SmartDoor, and SmartSensor</li>
  <li>User ⟶ many AutomationRules</li>
  <li>AutomationRule ⟶ triggers action on SmartDevices</li>
</ul>

<h2>🧠 OOP Principles Used</h2>
<ul>
  <li><strong>Inheritance:</strong> All smart devices extend SmartDevice.</li>
  <li><strong>Encapsulation:</strong> Device attributes like status and settings are private and accessed via methods.</li>
  <li><strong>Abstraction:</strong> SmartDevice defines general interface for all devices.</li>
  <li><strong>Association:</strong> User manages many devices; rules are linked to devices.</li>
</ul>

