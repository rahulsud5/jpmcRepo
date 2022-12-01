package com.sood.rahul.calculator;

import com.sood.rahul.entities.Showing;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.Collections;

public class CalculateTicketPrice {
    static KieContainer kc = null;

    static {
        KieServices ks = KieServices.Factory.get();

        // From the kie services, a container is created from the classpath
        kc = ks.getKieClasspathContainer();

    }

    public static Showing getTicketPrice(Showing showing) {
        KieSession ksession = kc.newKieSession("Discount-rulesKS");
        showing.setDiscountedPriceForShowing(showing.getMovieFee());
        ksession.insert(showing.getMovie());
        ksession.insert(showing);
        ksession.fireAllRules();
        showing.setDiscountedPriceForShowing(showing.getMovie().getTicketPrice() - Collections.max(showing.getDiscounts()));
        return showing;
    }
}
