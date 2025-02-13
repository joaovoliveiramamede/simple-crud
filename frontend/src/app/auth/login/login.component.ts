import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private service: AuthService
  ) {
    this.form = new FormGroup({});
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      email: ['', Validators.required],
      password: ['', Validators.required],
      rememberme: [false, Validators.required]
    })
  }

  public onSubmit(): void {
    console.log(this.form.get('email')?.value);

    let email = this.form.get('email')?.value
    let password = this.form.get('password')?.value

    const credentials = {
      username: email,
      password
    }

    this.service.login(credentials).subscribe(res => {
      console.log(res)
    })

  }


}
