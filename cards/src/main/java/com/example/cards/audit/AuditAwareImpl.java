package com.example.cards.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
/**
 * AuditAwareImpl is a Spring component that implements the AuditorAware interface.
 * It provides the current auditor's information for auditing purposes.
 */
@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware {
    /**
     * @return
     */
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("CARDS_MS");
    }
}
