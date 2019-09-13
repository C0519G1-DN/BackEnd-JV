package com.smile.mp3dao.entity;

        import org.springframework.data.annotation.CreatedBy;
        import org.springframework.data.annotation.CreatedDate;
        import org.springframework.data.annotation.LastModifiedBy;
        import org.springframework.data.annotation.LastModifiedDate;
        import org.springframework.data.jpa.domain.support.AuditingEntityListener;

        import javax.persistence.Column;
        import javax.persistence.EntityListeners;
        import javax.persistence.MappedSuperclass;
        import javax.persistence.Version;
        import java.io.Serializable;
        import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Version
    private long version;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_update")
    private LocalDateTime lastUpdateDate;

    @CreatedBy
    @Column(name = "create_by")
    private String createBy;

    @LastModifiedBy
    @Column(name = "last_update_by")
    private String latsUpdateBy;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getLatsUpdateBy() {
        return latsUpdateBy;
    }

    public void setLatsUpdateBy(String latsUpdateBy) {
        this.latsUpdateBy = latsUpdateBy;
    }
}

