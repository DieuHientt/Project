package com.alibou.project2023TMA.service;

import com.alibou.project2023TMA.entity.outcome;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface outcomeService {
    List<outcome> getAllOutcome();
    outcome saveOutcome(outcome outcome);

    Object getOutcome(BigInteger outcomeId);

    List<outcome> getOutcomeNotDeleted();

    outcome updateOutcome(BigInteger outcomeId, Map<String, String> formData);
}
//