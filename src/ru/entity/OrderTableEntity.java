package ru.entity;

import javafx.scene.control.TextArea;

public class OrderTableEntity {
        private final TextArea orderInfo = new TextArea();
        private final OrderEntity orderEntity;
    //idsight, description, adress, phone, webSite, imagePath
        public OrderTableEntity(OrderEntity orderEntity) {
            orderInfo.setWrapText(true);
            orderInfo.getStyleClass().add("sight-info-area");
            StringBuilder infoBuilder = new StringBuilder();
            infoBuilder.append(orderEntity.getDescription());

            orderInfo.setText(infoBuilder.toString());
            orderInfo.setEditable(false);
            orderInfo.setMouseTransparent(true);
            this.orderEntity = orderEntity;
        }

        public TextArea getOrderInfo() {
            return orderInfo;
        }

        public OrderEntity getOrderEntity() {
            return orderEntity;
        }
    }

