package com.practice.conferencejpa.repositories;

import com.practice.conferencejpa.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface TicketPriceJpaRepository extends JpaRepository<TicketPrice, Long> {
    //Using Query Annotation
    @Query(
            "select tp from TicketPrice tp where tp.basePrice < ?1 " +
                    "and tp.ticketType.includesWorkshop = true"
    )
    List<TicketPrice> getTicketsUnderPriceWithWorkshops(BigDecimal maxPrice);

    //Using Named Query
    List<TicketPrice> namedFindTicketsByPricingCategoryName(@Param("name") String name);

    //Using Native named Query
    List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);
}
