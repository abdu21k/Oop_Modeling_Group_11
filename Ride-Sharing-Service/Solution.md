<h1>🚗 Ride-Sharing Service – OOP Design</h1>

<h2>📌 Main Classes</h2>
<ul>
  <li>User (abstract)</li>
  <li>Passenger (inherits from User)</li>
  <li>Driver (inherits from User)</li>
  <li>Trip</li>
  <li>Vehicle</li>
  <li>Payment</li>
</ul>

<h2>🔹 Class: User (Abstract)</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Visibility</th><th>Description</th></tr>
  <tr><td>userID</td><td>String</td><td>private</td><td>Unique identifier</td></tr>
  <tr><td>name</td><td>String</td><td>private</td><td>User's full name</td></tr>
  <tr><td>email</td><td>String</td><td>private</td><td>Login email</td></tr>
  <tr><td>password</td><td>String</td><td>private</td><td>Encrypted password</td></tr>
  <tr><td>phone</td><td>String</td><td>private</td><td>Contact number</td></tr>
</table>
<br>
<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>login()</td><td>boolean</td><td>Validates credentials</td></tr>
  <tr><td>logout()</td><td>void</td><td>Logs the user out</td></tr>
  <tr><td>updateProfile()</td><td>void</td><td>Edits personal info</td></tr>
</table>

<h2>🔹 Class: Passenger</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>tripHistory</td><td>List&lt;Trip&gt;</td><td>Completed or cancelled trips</td></tr>
</table>
<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>requestRide(pickup, dropoff)</td><td>Trip</td><td>Creates a new trip request</td></tr>
  <tr><td>viewHistory()</td><td>List&lt;Trip&gt;</td><td>Returns ride history</td></tr>
</table>

<h2>🔹 Class: Driver</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>vehicle</td><td>Vehicle</td><td>Driver's vehicle details</td></tr>
  <tr><td>availability</td><td>boolean</td><td>Whether driver is online or not</td></tr>
  <tr><td>trips</td><td>List&lt;Trip&gt;</td><td>Trips assigned to the driver</td></tr>
</table>
<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>acceptRide(tripID)</td><td>boolean</td><td>Accepts a pending ride</td></tr>
  <tr><td>updateTripStatus(tripID, status)</td><td>void</td><td>Updates trip progress</td></tr>
</table>

<h2>🔹 Class: Vehicle</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>vehicleID</td><td>String</td><td>Unique ID</td></tr>
  <tr><td>plateNumber</td><td>String</td><td>Car's license plate</td></tr>
  <tr><td>model</td><td>String</td><td>Car model</td></tr>
  <tr><td>color</td><td>String</td><td>Car color</td></tr>
</table>

<h2>🔹 Class: Trip</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>tripID</td><td>String</td><td>Unique trip identifier</td></tr>
  <tr><td>passenger</td><td>Passenger</td><td>Linked passenger</td></tr>
  <tr><td>driver</td><td>Driver</td><td>Assigned driver</td></tr>
  <tr><td>pickup</td><td>String</td><td>Pickup location</td></tr>
  <tr><td>dropoff</td><td>String</td><td>Destination</td></tr>
  <tr><td>status</td><td>String</td><td>requested, accepted, completed, etc.</td></tr>
  <tr><td>fare</td><td>double</td><td>Calculated cost</td></tr>
</table>
<table border="1" cellpadding="5">
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>calculateFare()</td><td>double</td><td>Returns estimated fare</td></tr>
  <tr><td>updateStatus(newStatus)</td><td>void</td><td>Changes the trip status</td></tr>
</table>

<h2>🔹 Class: Payment</h2>
<table border="1" cellpadding="5">
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>paymentID</td><td>String</td><td>Transaction ID</td></tr>
  <tr><td>trip</td><td>Trip</td><td>Associated trip</td></tr>
  <tr><td>amount</td><td>double</td><td>Total fare paid</td></tr>
  <tr><td>status</td><td>String</td><td>Paid / Pending / Failed</td></tr>
</table>

<h2>🔄 Relationships</h2>
<ul>
  <li>Passenger ⟶ many Trips</li>
  <li>Driver ⟶ many Trips</li>
  <li>Driver ⟶ one Vehicle</li>
  <li>Trip ⟶ one Passenger, one Driver</li>
  <li>Trip ⟶ one Payment</li>
</ul>

<h2>🧠 OOP Principles Used</h2>
<ul>
  <li><strong>Encapsulation:</strong> Sensitive user/trip data is private, accessed via methods.</li>
  <li><strong>Inheritance:</strong> Passenger and Driver extend User.</li>
  <li><strong>Association:</strong> Driver ↔ Vehicle, Trip ↔ Users, etc.</li>
  <li><strong>Modularity:</strong> Each class has a clear single responsibility.</li>
</ul>

