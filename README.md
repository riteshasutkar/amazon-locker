
Three flows to cover
- Locker Selection flow
- Delivery flow
- Order Collection flow (Pickup)

To check
- Primary capabilities
- Error handling
- Scope boundaries

Primary capabilities 
- Are there different Sized compartments?
- Do we send customers their code? SMS/ EMAIL etc?
- Do we just give bar code/OTP or both?

Error Handling
- What happens if a package is never picked?
- Can customer only have one package assigned for pickup? So access tokens are unique per package?
- Do we have to only show compartments enough for the package Size?

Scope boundaries
- Are we designing all the flows or a single flow from putting the order to picking up the order?

Entities
- ~~Package~~ (this is just needed for its Size, not the whole model.So can be a simple input)
- Compartment
- Locker
- Access Tokens
- Locker Provider (since we also get to choose locker by zipcode requested)
- ~~Carrier/Driver~~ (because this is external data, we don't need to model it)
- ~~User/Customer~~ (same, we just use the data and send information to the details provided)