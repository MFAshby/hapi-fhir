package org.hl7.fhir.instance.model;

import org.hl7.fhir.instance.model.api.*;

public abstract class BaseReference extends Type implements IBaseReference, ICompositeType {

    /**
     * This is not a part of the "wire format" resource, but can be changed/accessed by parsers
     */
    private transient IBaseResource resource;

	public BaseReference(String theReference) {
    	setReference(theReference);
	}

    public BaseReference(IdType theReference) {
    	if (theReference != null) {
    		setReference(theReference.getValue());
    	} else {
    		setReference(null);
    	}
    }

	public BaseReference(IAnyResource theResource) {
		resource = theResource;
	}

	public BaseReference() {
	}

	/**
     * Retrieves the actual resource referenced by this reference. Note that the resource itself is not
     * a part of the FHIR "wire format" and is never transmitted or receieved inline, but this property
     * may be changed/accessed by parsers.
     */
    public IBaseResource getResource() {
        return resource;
    }

    @Override
	public IIdType getReferenceElement() {
		return new IdType(getReference());
	}

    abstract String getReference();

    /**
     * Sets the actual resource referenced by this reference. Note that the resource itself is not
     * a part of the FHIR "wire format" and is never transmitted or receieved inline, but this property
     * may be changed/accessed by parsers.
     */
    @Override
    public BaseReference setResource(IBaseResource theResource) {
        resource = theResource;
      return null;
    }

    @Override
	public boolean isEmpty() {
		return resource == null && super.isEmpty();
	}

}
