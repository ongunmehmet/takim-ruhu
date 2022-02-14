package com.takimruhu.dto

import com.takimruhu.entities.Sex

data class CustomerDto(  val customerId: Integer?,
                         val name: String?,
                         val surName: String?,
                         val Email: String?,
                         val password: String?,
                         val sex: Sex?,
                         val phoneNumber: String?,
                         val isAdmin: Boolean?,
                         val adresses: Map<String,String>?,
                         val favoredProducts: List<String>?,
                         val companyName: String?,
                         val vergiNo: String?,
                         val vergiDairesi: String?,

                         )