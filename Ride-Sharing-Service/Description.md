<h1>Domain 3: Ride-Sharing Service</h1>

<h2>Question</h2>
<p>
  This project is about modeling a Ride-Sharing Service using object-oriented programming principles. 
  The goal is to create a system that connects passengers who need rides with drivers who are available to provide those rides, 
  similar to popular platforms like Uber or Bolt.
</p>

<p>
  The system should include core features like user registration, ride booking, trip management, and payment tracking. 
  There will be two main types of users: <strong>Passengers</strong> and <strong>Drivers</strong>. Passengers should be able 
  to create accounts, request rides by entering their pickup and drop-off locations, and view trip history. Drivers should be 
  able to receive ride requests, accept or reject them, and update the trip status as it progresses.
</p>

<p>
  Each trip should track details like the driver assigned, the passenger, pickup and destination points, trip fare, and status 
  (requested, accepted, completed, or cancelled). The system should also be able to calculate the fare based on distance or 
  fixed pricing rules.
</p>

<p>
  The objective is to model all of this using proper OOP concepts like encapsulation, inheritance, and associations between 
  classes. For example, a passenger may have many trips, each trip is linked to one driver, and both user types should 
  inherit common attributes like name, contact info, and login details from a base User class.
</p>

<h2>Scope</h2>

<p>
  The Ride-Sharing system will include the following key features:
</p>

<ul>
  <li><strong>User Registration & Login:</strong> Both passengers and drivers can sign up and log in to the system.</li>

  <li><strong>Passenger Features:</strong> Passengers can request rides by entering pickup and drop-off locations. 
      They can also view ride history and ride status updates in real-time.</li>

  <li><strong>Driver Features:</strong> Drivers can set their availability, receive ride requests, accept or decline them, 
      and update the trip status (e.g., en route, arrived, completed).</li>

  <li><strong>Trip Management:</strong> Each ride request becomes a trip object, storing all relevant data such as assigned driver, 
      passenger, distance, fare, and timestamps.</li>

  <li><strong>Fare Calculation:</strong> The system can calculate trip fares using either fixed rates or based on estimated distance.</li>

  <li><strong>Trip Status Updates:</strong> Drivers and passengers can view the current status of a ride (requested, accepted, in progress, completed, or cancelled).</li>

  <li><strong>OOP Design:</strong> The system will use OOP features like inheritance (User → Passenger/Driver), encapsulation 
      for handling sensitive user and trip data, and associations to model real-world relationships (e.g., one driver to many trips).</li>
</ul>



