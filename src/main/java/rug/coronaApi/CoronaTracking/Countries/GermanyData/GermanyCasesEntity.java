package rug.coronaApi.CoronaTracking.Countries.GermanyData;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
public class GermanyCasesEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "Bundesland")
    private String bundeslandName;
    private BigInteger recovered;
    private BigInteger deaths;
    private BigInteger confirmed;
    private LocalDateTime updated;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;
}
