<h1>Domain 9: Smart Home Automation System</h1>

<h2>Question</h2>
<p>
  This project is focused on building an object-oriented model of a Smart Home Automation System. 
  In a modern smart home, everyday appliances and devices can be controlled remotely or automatically — 
  this system will simulate that kind of environment.
</p>

<p>
  The main idea is to design a system where a homeowner can manage various smart devices inside their house. 
  These devices could include things like lights, thermostats, smart locks, and sensors. 
  Each device should behave differently depending on its type, but they should also share common properties 
  like status, name, and connection state.
</p>

<p>
  The system should let users turn devices on or off, adjust settings (like brightness or temperature), and 
  monitor their current state. It should also support simple automation rules — for example, 
  "turn off all lights at 11 PM" or "lock doors when no one is home."
</p>

<p>
  The goal is to design this system using core object-oriented principles such as inheritance (for shared behavior across device types), 
  encapsulation (to protect device states), and associations (like linking devices to the user or a room).
</p>

<h2>Scope</h2>

<p>
  The system will cover the following main features:
</p>

<ul>
  <li><strong>User Control:</strong> A homeowner (the main user) should be able to log in and manage all smart devices in their home through a single interface.</li>

  <li><strong>Device Types:</strong> The system will include a variety of devices:
    <ul>
      <li><code>SmartLight</code>: Can be turned on/off, and brightness can be adjusted.</li>
      <li><code>SmartThermostat</code>: Controls room temperature, with settings for heating/cooling.</li>
      <li><code>SmartDoor</code>: Can be locked/unlocked, and status can be checked.</li>
      <li><code>SmartSensor</code>: Detects movement or environmental changes like temperature or light.</li>
    </ul>
  </li>

  <li><strong>Automation Rules:</strong> Users can set up simple triggers and conditions — 
      like automatic shutdown of devices at a certain time, or turning on lights when motion is detected.</li>

  <li><strong>Device Monitoring:</strong> Devices should report their current status and be able to respond to user commands in real-time.</li>

  <li><strong>System Design:</strong> All devices will inherit from a base <code>SmartDevice</code> class, 
      which defines common behavior and attributes like <code>deviceName</code>, <code>status</code>, and <code>location</code>.</li>

  <li><strong>Extensibility:</strong> The design should make it easy to add new types of devices later 
      without major changes to the system architecture.</li>
</ul>

