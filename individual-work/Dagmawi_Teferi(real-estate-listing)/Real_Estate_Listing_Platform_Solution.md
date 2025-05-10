<!DOCTYPE html>
<html>

<body>

<h1>Domain 10: Real Estate Listing Platform</h1>

<h2>Abstract Class: User</h2>
<table>
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>userID</td><td>String</td><td>Unique ID for each user</td></tr>
  <tr><td>name</td><td>String</td><td>User’s full name</td></tr>
  <tr><td>email</td><td>String</td><td>Email for login/contact</td></tr>
  <tr><td>password</td><td>String</td><td>Encrypted password</td></tr>
  <tr><td>role</td><td>String</td><td>'Buyer', 'Seller', or 'Agent'</td></tr>
</table>

<table>
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>login()</td><td>Boolean</td><td>Authenticates user</td></tr>
  <tr><td>logout()</td><td>void</td><td>Logs out user</td></tr>
  <tr><td>updateProfile()</td><td>void</td><td>Updates personal information</td></tr>
</table>

<h2>Class: Buyer (inherits User)</h2>
<table>
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>savedListings</td><td>List&lt;Property&gt;</td><td>Favorited properties</td></tr>
</table>

<table>
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>searchProperty()</td><td>List&lt;Property&gt;</td><td>Searches properties by filter</td></tr>
  <tr><td>saveListing()</td><td>void</td><td>Saves a property to favorites</td></tr>
  <tr><td>sendInquiry()</td><td>void</td><td>Sends inquiry to owner</td></tr>
</table>

<h2>Class: Seller / Agent (inherits User)</h2>
<table>
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>listings</td><td>List&lt;Property&gt;</td><td>Properties listed by user</td></tr>
</table>

<table>
  <tr><th>Method</th><th>Return Type</th><th>Description</th></tr>
  <tr><td>createListing()</td><td>Property</td><td>Creates a new listing</td></tr>
  <tr><td>editListing()</td><td>void</td><td>Modifies a listing</td></tr>
  <tr><td>deleteListing()</td><td>void</td><td>Deletes a listing</td></tr>
  <tr><td>viewInquiries()</td><td>List&lt;Inquiry&gt;</td><td>View buyer messages</td></tr>
</table>

<h2>Class: Property</h2>
<table>
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>propertyID</td><td>String</td><td>Unique ID for property</td></tr>
  <tr><td>title</td><td>String</td><td>Listing title</td></tr>
  <tr><td>price</td><td>Double</td><td>Property price</td></tr>
  <tr><td>location</td><td>String</td><td>Location of property</td></tr>
  <tr><td>type</td><td>String</td><td>House, Apartment, Land, etc.</td></tr>
  <tr><td>description</td><td>String</td><td>Property description</td></tr>
  <tr><td>images</td><td>List&lt;String&gt;</td><td>Image URLs</td></tr>
  <tr><td>owner</td><td>Seller/Agent</td><td>Owner of the listing</td></tr>
</table>

<h2>Class: Inquiry</h2>
<table>
  <tr><th>Attribute</th><th>Type</th><th>Description</th></tr>
  <tr><td>inquiryID</td><td>String</td><td>Unique inquiry ID</td></tr>
  <tr><td>sender</td><td>Buyer</td><td>Inquiry sender</td></tr>
  <tr><td>receiver</td><td>Seller/Agent</td><td>Recipient of inquiry</td></tr>
  <tr><td>message</td><td>String</td><td>The message content</td></tr>
  <tr><td>timestamp</td><td>DateTime</td><td>Time of message</td></tr>
</table>

<h2>Object-Oriented Principles Used</h2>
<ul>
  <li><strong>Encapsulation:</strong> All data is hidden via private fields with public getters/setters.</li>
  <li><strong>Inheritance:</strong> Buyer, Seller, and Agent inherit from the base User class.</li>
  <li><strong>Association:</strong> One-to-many relationship from Seller/Agent to Properties, and from Property to Inquiries.</li>
  <li><strong>Polymorphism:</strong> Users can act differently based on their type (Buyer/Seller/Agent).</li>
</ul>

</body>
</html>

