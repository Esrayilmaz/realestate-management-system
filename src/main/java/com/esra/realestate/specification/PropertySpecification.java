package com.esra.realestate.specification;

import com.esra.realestate.dto.request.PropertySearchRequestDto;
import com.esra.realestate.entity.Property;
import org.springframework.data.jpa.domain.Specification;

public class PropertySpecification {

    public static Specification<Property> filterBy(PropertySearchRequestDto request) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (request.getCustomerId() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("owner").get("id"), request.getCustomerId()));
            }

            if (request.getListingType() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("listingType"), request.getListingType()));
            }

            if (request.getPropertyType() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("propertyType"), request.getPropertyType()));
            }

            if (request.getCity() != null && !request.getCity().isBlank()) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("city"), request.getCity()));
            }

            if (request.getDistrict() != null && !request.getDistrict().isBlank()) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("district"), request.getDistrict()));
            }

            if (request.getMinSquareMeters() != null) {
                predicates = cb.and(predicates,
                        cb.greaterThanOrEqualTo(root.get("squareMeters"), request.getMinSquareMeters()));
            }

            if (request.getMaxSquareMeters() != null) {
                predicates = cb.and(predicates,
                        cb.lessThanOrEqualTo(root.get("squareMeters"), request.getMaxSquareMeters()));
            }

            if (request.getMinPrice() != null) {
                predicates = cb.and(predicates,
                        cb.greaterThanOrEqualTo(root.get("price"), request.getMinPrice()));
            }

            if (request.getMaxPrice() != null) {
                predicates = cb.and(predicates,
                        cb.lessThanOrEqualTo(root.get("price"), request.getMaxPrice()));
            }

            if (request.getMinRoomCount() != null) {
                predicates = cb.and(predicates,
                        cb.greaterThanOrEqualTo(root.get("roomCount"), request.getMinRoomCount()));
            }

            if (request.getMaxRoomCount() != null) {
                predicates = cb.and(predicates,
                        cb.lessThanOrEqualTo(root.get("roomCount"), request.getMaxRoomCount()));
            }

            if (request.getHeatingType() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("heatingType"), request.getHeatingType()));
            }

            if (request.getFurnished() != null) {
                predicates = cb.and(predicates,
                        cb.equal(root.get("furnished"), request.getFurnished()));
            }

            return predicates;
        };
    }
}