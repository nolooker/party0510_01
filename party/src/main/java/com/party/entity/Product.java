package com.party.entity;

import com.party.constant.ProductStatus;
import com.party.dto.ProductFormDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
@Getter@Setter@ToString
public class Product extends BaseEntity {

    @Id
    @Column(name = "room_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false,name = "price")
    private Integer price;

    @Column(nullable = false)
    private String fit;

    @Lob
    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    public void updateProduct(ProductFormDto productFormDto){
        this.name=productFormDto.getName();
        this.price=productFormDto.getPrice();
        this.fit=productFormDto.getFit();
        this.description= productFormDto.getDescription();
        this.productStatus=productFormDto.getProductStatus();
    }

    // Product 엔티티가 삭제될 때 해당 Product와 매핑되어 있는 모든 ProductImage 엔티티도 함께 삭제됩니다.
    // 또한, orphanRemoval = true 옵션을 추가하면 ProductImage 엔티티가 Product 엔티티와의 연관관계에서 해제될 때 해당 ProductImage 엔티티도 자동으로 삭제됩니다.

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> images = new ArrayList<>();



}
