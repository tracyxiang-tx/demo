package com.tracy.spring.basic.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class BeanImplTwo implements BeanInterface {

}
