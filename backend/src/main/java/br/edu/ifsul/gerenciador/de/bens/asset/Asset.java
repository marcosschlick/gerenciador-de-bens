package br.edu.ifsul.gerenciador.de.bens.asset;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.edu.ifsul.gerenciador.de.bens.department.Department;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assets")
public class Asset {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "asset_code", nullable = false, unique = true)
	private int assetCode;

	@Column(nullable = false)
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AssetType type;

	@Column(name = "acquisition_date", nullable = false)
	private LocalDate acquisitionDate;

	@Column(nullable = false)
	private BigDecimal value;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AssetStatus status;

	@ManyToOne
	@JoinColumn(name = "department_id", referencedColumnName = "id")
	private Department department;

	public Asset() {
		super();
	}
	
	public Asset(int assetCode, String description, AssetType type, LocalDate acquisitionDate, BigDecimal value,
			AssetStatus status, Department department) {
		super();
		this.assetCode = assetCode;
		this.description = description;
		this.type = type;
		this.acquisitionDate = acquisitionDate;
		this.value = value;
		this.status = status;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(int assetCode) {
		this.assetCode = assetCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AssetType getType() {
		return type;
	}

	public void setType(AssetType type) {
		this.type = type;
	}

	public LocalDate getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(LocalDate acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public AssetStatus getStatus() {
		return status;
	}

	public void setStatus(AssetStatus status) {
		this.status = status;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Asset(AssetRequestDTO data, Department department) {
		this.assetCode = data.assetCode();
		this.description = data.description();
		this.type = data.type();
		this.acquisitionDate = data.acquisitionDate();
		this.value = data.value();
		this.status = data.status();
		this.department = department;
	}
}
